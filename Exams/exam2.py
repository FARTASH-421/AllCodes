import pandas as pd
import numpy as np
import time
import tkinter as tk
from tkinter import filedialog
from kafka.admin import KafkaAdminClient, NewTopic
from kafka import KafkaProducer
from kafka import KafkaConsumer
from kafka.errors import TopicAlreadyExistsError
import json


root = tk.Tk()
root.withdraw()
file_path = filedialog.askopenfilename()

df = pd.read_csv(file_path)
df.dropna(inplace=True)

# Select column to categorize
print(end='\n\n')
print("-->  Choose Your Columns <--")
print(df.columns)
category_column = input("enter Your Columns: ")



categories = df[category_column].unique()


admin_client = KafkaAdminClient(bootstrap_servers="localhost:9092", client_id='test')


# Create topics for each category
topics = []
for category in categories:
    topics.append(NewTopic(name=f"{category}_topic", num_partitions=1, replication_factor=1))

# Create topics and handle exceptions if topics already exist
try:
    admin_client.create_topics(new_topics=topics, validate_only=False)
except TopicAlreadyExistsError as e:
    print("Topics already exist")

# Verify topics creation
existing_topics = admin_client.list_topics()
print("Existing topics:", existing_topics)



producer = KafkaProducer(bootstrap_servers=['localhost:9092'], value_serializer=lambda v: json.dumps(v).encode('utf-8'))

for category in categories:
    category_df = df[df[category_column] == category]
    for index, row in category_df.iterrows():
        print(f'send to data in Producer -> {category}_topic, {row.to_dict()}')
        producer.send(f"{category}_topic", row.to_dict())
        time.sleep(0.2)

producer.flush()


consumers = {}
for category in categories:
    consumers[category] = KafkaConsumer(
        f"{category}_topic",
        bootstrap_servers='localhost:9092',
        auto_offset_reset='earliest',
        enable_auto_commit=True,
        group_id='my-group',
        value_deserializer=lambda x: json.loads(x.decode('utf-8'))
    )

print("\n\nNow We read Data on Counsumer \n\n")
time.sleep(0.5)
for ex in consumers:
    print(ex, " -> ", consumers[ex])
    for iter in consumers[ex]:
        print(iter)
        time.sleep(0.2)

