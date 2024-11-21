.model small
.data

;23CS037

a db 37h, 02h, 03h, 04h    ; Array of bytes
ans db ?                   ; Variable to store the result

.code

mov dx, @data
mov ds, dx
mov si, offset a           ; Load the address of the array

mov bl, 00h                ; Initialize sum to 0
mov cl, 04h                ; Set loop counter to the number of elements in the array

lb:
    call fun_sum
    loop lb                ; Decrement CL and loop if CL != 0
    
mov ans, bl                ; Store the result in ans
hlt                        ; Halt the processor

fun_sum proc
    mov al, [si]           ; Load the current byte from the array
    test al, 01h           ; Test the least significant bit
    jnz label2             ; Jump to label2 if the LSB is not zero
    add bl, al             ; Add the value to the sum

label2:
    inc si                 ; Move to the next byte in the array
    ret

fun_sum endp

end     
