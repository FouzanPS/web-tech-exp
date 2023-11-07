from collections import deque

class State:
    def __init__(self, jug1, jug2):
        self.jug1 = jug1
        self.jug2 = jug2

    def __eq__(self, other):
        return self.jug1 == other.jug1 and self.jug2 == other.jug2

    def __hash__(self):
        return hash((self.jug1, self.jug2))

    def __str__(self):
        return f'({self.jug1}, {self.jug2})'

def water_jug_problem(capacity_jug1, capacity_jug2, target):
    def is_valid_state(state):
        return 0 <= state.jug1 <= capacity_jug1 and 0 <= state.jug2 <= capacity_jug2

    def get_successors(state):
        successors = []

        # Fill jug1 from the source
        successors.append(State(capacity_jug1, state.jug2))

        # Fill jug2 from the source
        successors.append(State(state.jug1, capacity_jug2))

        # Pour from jug1 to jug2
        pour_amount = min(state.jug1, capacity_jug2 - state.jug2)
        successors.append(State(state.jug1 - pour_amount, state.jug2 + pour_amount))

        # Pour from jug2 to jug1
        pour_amount = min(state.jug2, capacity_jug1 - state.jug1)
        successors.append(State(state.jug1 + pour_amount, state.jug2 - pour_amount))

        # Empty jug1
        successors.append(State(0, state.jug2))

        # Empty jug2
        successors.append(State(state.jug1, 0))

        return [s for s in successors if is_valid_state(s)]

    start_state = State(0, 0)
    visited = set()
    queue = deque([(start_state, [])])  # Store state and steps taken

    while queue:
        current_state, steps = queue.popleft()

        if current_state.jug1 == target or current_state.jug2 == target:
            return steps  # Return the steps to reach the target

        visited.add(current_state)

        for successor in get_successors(current_state):
            if successor not in visited:
                new_steps = steps + [successor]  # Add the current step
                queue.append((successor, new_steps))

    return None

if __name__ == '__main__':
    jug1_capacity = 4
    jug2_capacity = 3
    target_amount = 2
    solution = water_jug_problem(jug1_capacity, jug2_capacity, target_amount)

    if solution:
        print("Steps to reach the target:")
        for step in solution:
            print(step)
    else:
        print("No solution found.")
