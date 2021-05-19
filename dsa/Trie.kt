class Trie<Key> {

    // parent root
    private val root = TrieNode<Key>(key = null, parent = null)

    // insert to the tree
    fun insert(list: List<Key>) {
        // starting from the parent root node
        // stores the current node
        var current = root

        // check if the node value exists, if not create a new node
        list.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }
        current.isLeaf = true
    }

    // check if is a word
    // here input is list of characters i.e a string.toList()
    fun contains(list: List<Key>): Boolean {
        var current = root

        // if child exists return true else return false
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }

        // this helps to identify if the last element of list is the leaf node
        // that implies the word formed does exist
        // else that word is just a subset of a larger word
        return current.isLeaf
    }
}

/*Node for Trie DS: here key is the character/alphabet ,
 and parent is the parent node for the same node(node linked above to the node in the tree)*/
class TrieNode<Key>(var key: Key?, var parent: TrieNode<Key>?) {
    // info for children
    val children: HashMap<Key, TrieNode<Key>> = HashMap()

    // is last node
    var isLeaf = false
}
