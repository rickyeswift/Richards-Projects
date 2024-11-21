/*
Name: Richard Elliot Jr
Title: CMSC 304 Homework Assignment 3
Last Date Modified: 10/7/2024
*/
#include "LinkedList.h"
#include <stdlib.h>
#include <string.h>

struct Node* createNode(char* data) {
    // Allocate memory for the new node
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        return NULL; // malloc failed
    }
    
    // Allocate memory for the data and copy it
    newNode->data = (char*)malloc(strlen(data) + 1); // +1 for the null terminator
    if (newNode->data == NULL) {
        free(newNode); // clean up
        return NULL;
    }
    strcpy(newNode->data, data);

    // Set the next pointer to NULL since this is a new node
    newNode->next = NULL;

    return newNode;
}

void insertAtEnd(struct Node** head, struct Node* newNode) {
    if (head == NULL || newNode == NULL) return;

    // If the list is empty, the newNode becomes the head
    if (*head == NULL) {
        *head = newNode;
        return;
    }

    // Traverse to the end of the list
    struct Node* current = *head;
    while (current->next != NULL) {
        current = current->next;
    }

    // Set the next pointer of the last node to the newNode
    current->next = newNode;
}

struct Node* createList(FILE* inf) {
    if (inf == NULL) return NULL;

    char line[MAX_LINE_SIZE]; // MAX_LINE_SIZE is defined in Givens.h
    struct Node* head = NULL;
    struct Node* tail = NULL;

    while (fgets(line, sizeof(line), inf) != NULL) {
        // Strip newline character
        line[strcspn(line, "\n")] = 0;

        // Create a new node
        struct Node* newNode = createNode(line);
        if (newNode == NULL) {
            // Handle malloc failure
            freeList(&head); // Free the list created so far
            return NULL; 
        }

        // Insert the node at the end of the list
        if (head == NULL) {
            head = newNode;
            tail = head;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    return head;
}

struct Node* removeNode(struct Node** head, int index) {
    if (head == NULL || *head == NULL || index < 0) return NULL;

    struct Node* temp = *head;
    struct Node* prev = NULL;

    // If the node to be removed is the head
    if (index == 0) {
        *head = temp->next; // Move head
        return temp;
    }

    // Traverse the list to find the node to be removed
    for (int i = 0; temp != NULL && i < index; i++) {
        prev = temp;
        temp = temp->next;
    }

    // If index is out of bounds
    if (temp == NULL) return NULL;

    // Unlink the node from the list
    prev->next = temp->next;

    return temp;
}

void traverse(struct Node* head) {
    struct Node* current = head;

    while (current != NULL) {
        printf("%s\n", current->data);
        current = current->next;
    }
}

void freeNode(struct Node* aNode) {
    if (aNode != NULL) {
        free(aNode->data); // Free the data
        free(aNode); // Free the node itself
    }
}

void freeList(struct Node** head) {
    struct Node* current = *head;
    struct Node* nextNode = NULL;

    while (current != NULL) {
        nextNode = current->next; // Store the next node
        freeNode(current); // Free the current node
        current = nextNode; // Move to the next node
    }

    *head = NULL; // Set head to NULL after freeing the list
}