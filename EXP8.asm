.model isPalindrome?
;23CS037



org 100h

jmp start

mi:
    s db 'abba'
    s_size = $ - mi
    db 0Dh,0Ah,'$'; We added some extra values so that not counting of the first and the last char can be managed

start:
    mov ah,09h
    mov dx,offset s
    int 21h

    lea di,s ;Load effective address
    mov si,di
    add si,s_size
    dec si ;Because it inculde one extra char, Thus between di and si we have all the char
    mov cx,s_size
    cmp cx,1 
    je is_palindrome ; Checks for the zero flag if 1 then it will jump
    shr cx,1

next_char:
    mov al,[di]
    mov bl,[si]
    cmp al,bl
    jne not_palindrome
    inc di
    dec si
loop next_char

is_palindrome:
    mov ah,09h
    mov dx,offset msg1
    int 21h

jmp stop   

not_palindrome:
    mov ah,09h
    mov dx,offset msg2
    int 21h

stop:
    mov ah,01h
    int 21h

ret

msg1 db "This is a palindrome$"
msg2 db "This is not a palindrome$" 
