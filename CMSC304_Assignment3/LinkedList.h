#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include "Givens.h" // This will include the Node struct and constants like MAX_LINE_SIZE
#include <stdio.h> // For FILE operations

// Function prototypes

// Creates a new Node with a copy of the given data
struct Node* createNode(char* data);

// Inserts a new node at the end of the linked list
void insertAtEnd(struct Node** head, struct Node* newNode);

// Creates a linked list by reading lines from the given file
struct Node* createList(FILE* inf);

// Removes the node at the specified index and returns it
struct Node* removeNode(struct Node** head, int index);

// Traverses and prints each node's data in the list
void traverse(struct Node* head);

// Frees the memory of a single node
void freeNode(struct Node* aNode);

// Frees the memory of all nodes in the list
void freeList(struct Node** head);

#endif