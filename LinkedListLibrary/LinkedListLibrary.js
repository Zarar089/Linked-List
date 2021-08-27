class Node {


    constructor(data) {
        this.data = data;
        this.next = null;
    }

    setData(data) {
        this.data = data;
    }

    getData() {
        return this.data;
    }

    setNext(next) {
        this.next = next;
    }

    getNext() {
        return this.next;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.listSize = 0;
    }

    getHead() {
        return this.head;
    }

    //Add a new node at the end of the linked list
    add(data) {
        let node = new Node(data);

        if (this.head === null) {
            this.head = node;
        } else {
            let curr = this.head;
            while (curr.next !== null) {
                curr = curr.next;
            }

            curr.next = node;
        }

        this.listSize++;
    }

    //Add a node at the start of the linked list
    addAtStart(data) {
        let node = new Node(data);

        node.next = head;
        head = node;

        this.listSize++;
    }


    //Add a node at a specified position
    addAt(data, pos) {

        if (pos < 1) {
            alert("Invalid position");
            return;

        } else {
            let node = new Node(data);
            if (pos === 1) {
                this.addAtStart(node);
            } else {
                let curr = this.head;
                for (let i = 1; i <= pos - 2; i++) {
                    curr = curr.next;
                }

                let temp = curr.next;
                curr.next = node;
                node.next = temp;
            }
        }
    }


    //Add all elements of an array at the end of a linked list
    addAll(arr) {
        for (const x of arr) {
            this.add(x);
        }
    }

    //Add all elements of an array at a specified position of the linked list
    addAllAt(arr, pos) {
        if (pos > this.listSize) {
            alert("Invalid Position");
            return;
        }
        this.listSize += arr.length;
        for (const x of arr) {
            this.addAt(x, pos);
            pos++;
        }
    }

    //Delete a node from the end of a linked list
    delete() {
        let curr = this.head;

        while (curr.next.next !== null) {
            curr = curr.next;
        }

        curr.next = null;
        this.listSize--;
    }

    //Delete a node at a given position
    deleteAt(pos) {
        if (pos < 1 || pos > this.listSize) {
            alert("Invalid Position");
            return;
        }

        if (this.head === null) {
            alert("Empty List");
            return;
        }

        let curr = this.head;

        for (let i = 1; i < pos - 1; i++) {
            curr = curr.next;
        }

        let temp = curr.next.next;
        curr.next = temp;

    }

    //Delete the first occurence of a given value
    deleteData(val) {
        let indx = 1;
        let curr = this.head;
        while (curr.next !== null) {
            if (curr.data === val) {
                this.deleteAt(indx);
                break;
            }
            curr = curr.next;
            indx++;
        }
    }


    //Removes all nodes with data equivalent to an array
    removeAll(arr) {
        for (const x of arr) {
            if (this.contains(x)) {
                this.deleteData(x);
            }
        }
    }

    removeFromRange(strtPos, endPos) {
        if (strtPos < 1 || strtPos > this.listSize || endPos < 1 || endPos > this.listSize || strtPos > endPos) {
            alert("Invalid range");
            return;
        }
        let curr = this.head;
        let count = 1;
        while (curr.next != null) {
            curr = curr.next;
            if (count >= strtPos && count <= endPos) {
                this.deleteAt(count);
            }
            count++;
        }
    }

    //Clearing the entire linked list
    clear() {
        while (!this.isEmpty()) {
            this.delete();
        }
    }

    //Checks if a certain value is present in the list.
    contains(data) {
        let curr = this.head;
        while (curr.next !== null) {
            if (x == curr.data) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    //Returns the list length
    getSize() {
        return this.listSize;
    }


    //Checks if the list is empty;
    isEmpty() {
        return this.listSize === 0;
    }

    //Get the index of the first occurence of a value
    indexOf(value) {
        let indx = 0;
        let curr = this.head;
        while (curr.next !== null) {
            if (value == curr.data) {
                return indx;
            }
            curr = curr.next;
            indx++;
        }
        return -1;
    }

    lastIndexOf(value) {
        let last_indx = -1;
        let curr_indx = 1;
        let curr = this.head;
        while (curr.next != null) {
            if (value == curr.data) {
                if (last_indx < curr_indx) {
                    last_indx = curr_indx;
                }
            }
            curr = curr.next;
            curr_indx++;
        }

        return last_indx;
    }


    //Prints the entire list
    printList() {
        let curr = this.head;
        while (curr.next !== null) {
            let num = curr.getData();
            console.log(num);
            curr = curr.next;
        }
        console.log(curr.data);
    }

    set(pos, data) {
        let curr = this.head;
        for (let i = 1; i < pos; i++) {
            curr = curr.next;
        }

        curr.data = data;
    }
}

let Llist = new LinkedList();

Llist.add(10);
Llist.add(15);
Llist.add(10);
Llist.add(25);
Llist.add(10);
Llist.add(35);

console.log(Llist.indexOf(10));
Llist.set(1, 9);
console.log(Llist.indexOf(10));
Llist.printList();