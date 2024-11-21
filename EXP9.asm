.model EXP9
;23CS037
.data
    ans dw dup(0)
    tcx dw dup(2)
    
.code
    mov ax,@data
    mov ds,ax
    mov cx,0008h
    
    next:
        mov ax,cx
        test al,01h
        jz even_number
        mov tcx,cx
        call factorial
        mov cx,tcx
        jmp odd_number
        
    even_number:
        sub ans,cx
        
    odd_number:
    
    loop next
hlt

factorial proc
    
    mov ax,0001h
    
    lb: mul cx
    loop lb
    
    add ans,ax
    
    ret
factorial endp
