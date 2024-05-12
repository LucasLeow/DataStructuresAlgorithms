class TreeNode:
    def __init__(self, data):
        self.data = data
        self.children = []
        self.parent = None

    def add_child(self, *children):
        for child in children:
            child.parent = self
            self.children.append(child)

    def print_tree(self):
        # Tree is recursive data structure
        # Printing will also be recursive
        spaces = ' ' * self.get_level() * 3
        prefix = spaces + '|__' if self.parent else ''
        print(prefix, self.data)
        if len(self.children) > 0:
            for child in self.children:
                child.print_tree()

    def get_level(self):
        level = 0
        p = self.parent
        while (p):
            p = p.parent
            level += 1
        return level


def build_product_tree():

    root = TreeNode("Electronics")

    laptop = TreeNode("Laptops")
    laptop.add_child(
        TreeNode("Apple Macbook"),
        TreeNode("Microsoft Surface"),
        TreeNode("Lenovo Thinkpad")
    )

    cellphone = TreeNode("CellPhone")
    cellphone.add_child(
        TreeNode("Apple IPhone"),
        TreeNode("Microsoft Surface Duo"),
        TreeNode("Samsung Galaxy")
    )

    tv = TreeNode("Televisions")
    tv.add_child(
        TreeNode("Samsung"),
        TreeNode("LG")
    )

    root.add_child(laptop, cellphone, tv)
    return root


if __name__ == '__main__':
    product_tree = build_product_tree()
    product_tree.print_tree()
