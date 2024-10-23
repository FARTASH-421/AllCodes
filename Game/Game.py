import pygame

# ابعاد پنجره بازی
WIDTH = 1000
HEIGHT = 800

# رنگ‌ها
BLUE = (0, 0, 255)
PINK = (255, 192, 203)  # رنگ صورتی
GREEN = (0, 255, 0)
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

# مسیر فایل‌ها
PATH = "C:\\Users\\Fartash\Desktop\\New folder\\Game\\"

# آماده‌سازی صفحه بازی
pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("کشیش و ادمخوار")

# بارگذاری تصاویر
h1_image = pygame.image.load(PATH + "h1.jpeg")
h11_image = pygame.image.load(PATH + "h11.jpeg")
h2_image = pygame.image.load(PATH + "h2.jpeg")

# تغییر اندازه تصاویر
h1_image = pygame.transform.scale(h1_image, (100, 100))
h11_image = pygame.transform.scale(h11_image, (200, 100))
h2_image = pygame.transform.scale(h2_image, (100, 100))

# قرار دادن تصاویر در موقعیت مناسب
# قایق
boat_rect = h11_image.get_rect()
boat_rect.center = (WIDTH // 2, HEIGHT // 2)

# تعداد ادم‌خوارها
h1_count = 3

# تعداد کشیش‌ها
h2_count = 3

# تنظیم موقعیت ادم‌خوارها
h1_rects = []
for i in range(h1_count):
    h1_rect = h1_image.get_rect()
    h1_rect.center = (WIDTH // 2 + (i - h1_count // 2) * (150 + 20), HEIGHT // 3 * 2 + 100)
    h1_rects.append(h1_rect)

# تنظیم موقعیت کشیش‌ها
h2_rects = []
for i in range(h2_count):
    h2_rect = h2_image.get_rect()
    h2_rect.center = (WIDTH // 2 + (i - h2_count // 2) * (150 + 20), HEIGHT // 3 * 2 - 100)
    h2_rects.append(h2_rect)

# تعداد کشیش‌ها
h2_count = 3

# کشیش‌ها
h2_rects = []
for i in range(h2_count):
    h2_rect = h2_image.get_rect()
    h2_rect.center = (WIDTH // 2 + (i - h2_count // 2) * 150, HEIGHT // 3 * 2)
    h2_rects.append(h2_rect)

# حلقه بازی
running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # رسم محیط بازی
    screen.fill(BLUE)  # زمینه آبی
    pygame.draw.rect(screen, PINK, (0, 0, WIDTH, HEIGHT // 3))  # محیط صورتی بالا
    pygame.draw.rect(screen, BLUE, (0, HEIGHT // 3, WIDTH, HEIGHT // 3))  # آب وسط
    pygame.draw.rect(screen, GREEN, (0, HEIGHT // 3 * 2, WIDTH, HEIGHT // 3))  # محیط سبز پایین

    # نمایش تصاویر
    for h1_rect in h1_rects:
        screen.blit(h1_image, h1_rect)
    screen.blit(h11_image, boat_rect)
    for h2_rect in h2_rects:
        screen.blit(h2_image, h2_rect)

    pygame.display.update()

pygame.quit()