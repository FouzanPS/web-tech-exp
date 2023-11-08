import itertools

def calculate_total_distance(order, distances):
    total_distance = 0
    for i in range(len(order) - 1):
        total_distance += distances[order[i]][order[i + 1]]
    total_distance += distances[order[-1]][order[0]]  # Return to the starting point
    return total_distance

def traveling_salesman_bruteforce(distances):
    num_cities = len(distances)
    cities = list(range(num_cities))
    min_distance = float("inf")
    best_order = None

    for order in itertools.permutations(cities):
        distance = calculate_total_distance(order, distances)
        if distance < min_distance:
            min_distance = distance
            best_order = order

    return best_order, min_distance

if __name__ == '__main__':
    # Define the distances between cities (replace with your own data)
    distances = [
        [0, 10, 15, 20],
        [10, 0, 35, 25],
        [15, 35, 0, 30],
        [20, 25, 30, 0]
    ]

    best_order, min_distance = traveling_salesman_bruteforce(distances)
    print("Optimal Tour Order:")
    for city in best_order:
        print(city, end=' -> ')
    print(best_order[0])  # Return to the starting city
    print("Minimum Total Distance:", min_distance)
