import numpy as np
import pandas as pd
from ydata_profiling import ProfileReport

namePath = "data.csv"

df = pd.read_csv(namePath)
profile = ProfileReport(df, title="Fartash Report")

print(df.head())
# for save file

nameRe = "Fartash"
profile.to_file(f"{nameRe}_report.html")

