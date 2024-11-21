.ORIG x3000

; Initialize variables
    LEA     R0, PROMPT        ; Load prompt message into R0
    PUTS                    ; Print prompt to console
    GETC                    ; Read in user input
    OUT                     ; Echo user input back to console
    ADD     R1, R0, #-10    ; Check if input is equal to '1'
    BRz     ODD_SUM         ; Branch if input is equal to '1'

; Sum even numbers
EVEN_SUM
    LD     R2, MEM_START    ; Load first memory address into R2
    LD      R3, MEM_END      ; Load last memory address into R3
    ADD     R4, R0, #0       ; Initialize sum to zero
EVEN_LOOP
    ADD     R4, R4, R2       ; Add current value to sum
    ADD     R2, R2, #2       ; Move to next memory address
    BRp     EVEN_LOOP       ; Continue loop if address is positive
    STR     R4, SUM         ; Store final sum in memory
    LEA     R0, END_MSG     ; Load end message into R0
    PUTS                    ; Print end message to console
    LD      R7, EXIT        ; Load exit command into R7
    JMP     R7              ; Halt machine

; Sum odd numbers
ODD_SUM
    LD    R2, MEM_START    ; Load first memory address into R2
    LD      R3, MEM_END      ; Load last memory address into R3
    ADD     R4, R0, #0       ; Initialize sum to zero
ODD_LOOP
    ADD     R5, R2, #-1      ; Check if current value is odd
    BRn     ODD_SKIP        ; Skip if value is even
    ADD     R4, R4, R2       ; Add current value to sum
ODD_SKIP
    ADD     R2, R2, #2       ; Move to next memory address
    BRp     ODD_LOOP        ; Continue loop if address is positive
    STR     R4, SUM         ; Store final sum in memory
    LEA     R0, END_MSG     ; Load end message into R0
    PUTS                    ; Print end message to console
    LD      R7, EXIT        ; Load exit command into R7
    JMP     R7              ; Halt machine

; Variables
PROMPT      .STRINGZ "Please enter a 1 to sum all odd numbers. Otherwise all even numbers will be summed\n"
END_MSG     .STRINGZ "\nThe sum of values was: "
MEM_START   .FILL   x3200   ; First memory address to check
MEM_END     .FILL   x32FF   ; Last memory address to check
SUM         .FILL   #0      ; Final sum of numbers
EXIT        .FILL   x25     ; Halt command

.END



