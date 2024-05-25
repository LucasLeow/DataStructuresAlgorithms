class TreeNode:
    def __init__(self, name):
        self.name = name
        self.children = []
        self.parent = None

    def add_child(self, *children):
        for child in children:
            child.parent = self
            self.children.append(child)

    def print_tree(self, level):
        cur_level = self.get_level()
        spaces = ' ' * cur_level * 3
        prefix = spaces + '|__' if self.parent else ''
        print(prefix, self.name)
        if cur_level == level:
            return
        # Tree is recursive data structure
        # Printing will also be recursive

        if len(self.children) > 0:
            for child in self.children:
                child.print_tree(level)

    def get_level(self):
        level = 0
        p = self.parent
        while (p):
            p = p.parent
            level += 1
        return level


def build_tree():

    glob = TreeNode("Global")

    india = TreeNode("India")

    guj = TreeNode("Gujarat")
    guj.add_child(
        TreeNode("Ahmedabad"),
        TreeNode("Baroda")
    )
    kar = TreeNode("Karnataka")
    kar.add_child(
        TreeNode("Bangluru"),
        TreeNode("Mysore")
    )
    india.add_child(
        guj,
        kar
    )

    usa = TreeNode("USA")

    nj = TreeNode("New Jersey")
    nj.add_child(
        TreeNode("Princeton"),
        TreeNode("Trenton")
    )

    cal = TreeNode("California")
    cal.add_child(
        TreeNode("San Francisco"),
        TreeNode("Mountain View"),
        TreeNode("Palo Alto")
    )

    usa.add_child(
        nj,
        cal
    )

    glob.add_child(
        india,
        usa
    )

    return glob


if __name__ == '__main__':
    country_tree = build_tree()
    country_tree.print_tree(2)
