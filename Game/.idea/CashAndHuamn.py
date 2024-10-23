
import pygame
import math

WIDTH = 1000
HEIGHT = 800

BLUE = (0, 0, 255)
PINK = (255, 192, 203)  # رنگ صورتی
GREEN = (0, 255, 0)
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

PATH = "C:\\Users\\Fartash\Desktop\\New folder\\Game\\h1.jpeg"

# آماده‌سازی صفحه بازی
pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("کشیش و ادمخوار")



from pathlib import Path

PATH = Path(__file__).resolve().parent
# print(PATH / "h1.png" )

pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("کشیش و ادمخوار")
print(PATH)
path1 = "C:\\Users\\Fartash\Desktop\\New folder\\Game\\h1.jpeg"

paht2 = "C:\\Users\\Fartash\Desktop\\New folder\\Game\\h11.jpeg"
paht3 ="C:\\Users\\Fartash\Desktop\\New folder\\Game\\h2.jpeg"

h1_image = pygame.image.load(path1)
h11_image = pygame.image.load(paht2)
h2_image = pygame.image.load(paht3)

h1_image = pygame.transform.scale(h1_image, (100, 100))
h11_image = pygame.transform.scale(h11_image, (200, 100))
h2_image = pygame.transform.scale(h2_image, (100, 100))

boat_rect = h11_image.get_rect()
boat_rect.center = (WIDTH // 2, HEIGHT // 2)

h1_count = 3
h2_count = 3

h1_rects = []
for i in range(h1_count):
    h1_rect = h1_image.get_rect()
    h1_rect.center = (WIDTH // 2 + (i - h1_count // 2) * (150 + 20), HEIGHT // 3 * 2 + 100)
    h1_rects.append(h1_rect)

h2_rects = []
for i in range(h2_count):
    h2_rect = h2_image.get_rect()
    h2_rect.center = (WIDTH // 2 + (i - h2_count // 2) * (150 + 20), HEIGHT // 3 * 2 - 100)
    h2_rects.append(h2_rect)

def heuristic(start, goal):
    x1, y1 = start
    x2, y2 = goal
    return math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)

def get_neighbors(position):
    neighbors = []
    x, y = position

    if y > 100:
        neighbors.append((x, y - 100))

    if y < HEIGHT - 100:
        neighbors.append((x, y + 100))

    if x > 150:
        neighbors.append((x - 150, y))

    if x < WIDTH - 150:
        neighbors.append((x + 150, y))

    return neighbors

def astar(start, goal):
    open_set = [start]
    came_from = {}
    g_score = {start: 0}
    f_score = {start: heuristic(start, goal)}

    while open_set:
        current = min(open_set, key=lambda x: f_score[x])

        if current == goal:
            path = [current]
            while current in came_from:
                current = came_from[current]
                path.append(current)
            path.reverse()
            return path

        open_set.remove(current)
        for neighbor in get_neighbors(current):
            tentative_g_score = g_score[current] + 1
            if neighbor not in g_score or tentative_g_score < g_score[neighbor]:
                came_from[neighbor] = current
                g_score[neighbor] = tentative_g_score
                f_score[neighbor] = tentative_g_score + heuristic(neighbor, goal)
                if neighbor not in open_set:
                    open_set.append(neighbor)



def run_game():
    start = (WIDTH // 2, HEIGHT // 6)
    goal = (WIDTH // 2, HEIGHT // 6 * 5)

    path = astar(start, goal)

    if path:
        current_index = 0
        boat_rect.center = path[current_index]  # تنظیم مختصات اولیه
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    return

            if current_index < len(path) - 1:
                current = path[current_index]
                next_position = path[current_index + 1]
                dx = next_position[0] - current[0]
                dy = next_position[1] - current[1]

                if dx > 0:
                    boat_rect.move_ip(150, 0)
                elif dx < 0:
                    boat_rect.move_ip(-150, 0)
                elif dy > 0:
                    boat_rect.move_ip(0, 100)
                elif dy < 0:
                    boat_rect.move_ip(0, -100)

                current_index += 1

            screen.fill(BLACK)
            screen.blit(h11_image, boat_rect)

            for h1_rect in h1_rects:
                screen.blit(h1_image, h1_rect)

            for h2_rect in h2_rects:
                screen.blit(h2_image, h2_rect)

            pygame.display.flip()
            pygame.time.Clock().tick(60)

            pygame.display.update()

run_game()
