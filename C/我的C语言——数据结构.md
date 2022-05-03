# 一、link——链表就这么诞生了

```C
struct link{
    // struct link *pre;  双向链表
    int data;  // 存储当前节点的数据      ---> 数据域
    struct link *next;  // 指向下一个节点 ---> 指针域
    // 当最后一个节点指向头结点后，就是循环链表
    // 空指针NULL来定义链表的结尾
}Sqlink;
// 占用的内存可以是不连续的
```



## 1. 向链表添加一个节点

```C++
void insert(Sqlink head, int val){
    if (head==NULL){
        Sqlink p = new Sqlink();
        p.data = val;
        p.next = NULL;
        head = p;
    }else{
        /*Sqlink p = new Sqlink();
		p.data = val;
        p.next = head.next;
        head.next = p;   */
        
        // 有序插入
        Sqlink p = (struct link *)malloc(sizeof(struct link));
        Sqlink pre = (struct link *)malloc(sizeof(struct link));
		pre = head;
        p = head.next;
        while (p.next!=NULL && p.data<=val){
            p = p.next;
            pre = pre.next;
        }
        Sqlink res = (struct link *)malloc(sizeof(struct link));
        res.next = p;
        pre.next = res;
        free(p);
        free(pre);
    }
}
```



## 2. 删除

```C++
void delete(Sqlink head, int val){
    Sqlink p = (struct link *)malloc(sizeof(struct link));
    Sqlink pre = (struct link *)malloc(sizeof(struct link));
    pre = head;
    p = head.next;
    while (p!=NULL && p.data!=val){
        p = p.next;
        pre = pre.next;
    }
    if(p!=NULL){
        Sqlink temp = (struct link *)malloc(sizeof(struct link));
        temp = p;
        pre.next = p.next;
        free(temp);
    }else{
        printf("没有这个节点。")
    }
    free(p);
    free(pre);
}
```



## 1. 输出

```C
void Travel(Sqlink head){
    struct link *p = head;
    int j;
    while(p!=NULL){
        printf("%5d%10d\n", j, p->data);
        p = p->next;
        j++;
    }
}
```



# 二、queue



