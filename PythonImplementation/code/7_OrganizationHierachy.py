class TreeNode:
    def __init__(self, name, designation):
        self.name = name
        self.designation = designation
        self.children = []
        self.parent = None

    def add_child(self, *children):
        for child in children:
            child.parent = self
            self.children.append(child)

    def print_tree(self, type="both"):
        spaces = ' ' * self.get_level() * 3
        prefix = spaces + '|__' if self.parent else ''
        if (type == "name"):
            print(prefix, self.name)
        elif (type == "designation"):
            print(prefix, self.designation)
        elif (type == "both"):
            print(f"{prefix}{self.designation} ({self.name})")
        # Tree is recursive data structure
        # Printing will also be recursive

        if len(self.children) > 0:
            for child in self.children:
                child.print_tree(type)

    def get_level(self):
        level = 0
        p = self.parent
        while (p):
            p = p.parent
            level += 1
        return level


def build_tree():

    ceo = TreeNode("CEO", "Nilupul")

    cto = TreeNode("CTO", "Chinmay")

    infra_head = TreeNode("Infrastructure Head", "Vishwa")
    infra_head.add_child(
        TreeNode("Cloud Manager", "Dhaval"),
        TreeNode("App Manager", "Abhijit")
    )

    cto.add_child(
        infra_head,
        TreeNode("Application Head", "Aamir"),
    )

    hr = TreeNode("HR Head", "Gels")
    hr.add_child(
        TreeNode("Recruitment Manager", "Peter"),
        TreeNode("Policy Manager", "Waqas"),
    )

    ceo.add_child(
        cto,
        hr
    )

    return ceo


if __name__ == '__main__':
    org_tree = build_tree()
    org_tree.print_tree("name")
    org_tree.print_tree("designation")
    org_tree.print_tree()
