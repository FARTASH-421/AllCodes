import telebot
# TOKEN = "6369610509:AAGzMoLYi59A-Fy-_-PpdPZNqFmVcAIUqAc"

bot = telebot.TeleBot("6643013287:AAGsapIWQGD0JxTXgEe34kae8LG9tX9al6Q")

@bot.message_handler(commands=['start', 'help'])
def send_welcome(message):
    bot.reply_to(message, "Hi!, How are you?\nplease withe for answer.\nThanks a lat for with")

@bot.message_handler(func=lambda message: True)
def echo_all(message):
    bot.reply_to(message, message.text)

bot.infinity_polling()