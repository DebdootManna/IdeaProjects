org 100h

; Performing addition of two 32-bits number 
; first number : 10371B64h
; second number : 9135F13Ah
mov ax,1B64h
mov bx,0F13Ah
add ax,bx

mov cx,3000h
mov ds,cx
mov di,0020h

mov [di],ax

mov ax,1037h
mov bx,9135h
adc ax,bx

inc di
inc di

mov [di],ax

ret
