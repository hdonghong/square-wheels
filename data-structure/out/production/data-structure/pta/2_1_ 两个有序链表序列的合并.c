#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;
typedef struct Node *PtrToNode;
struct Node {
    ElementType Data;
    PtrToNode   Next;
};
typedef PtrToNode List;

List Read(); /* 细节在此不表 */
void Print( List L ); /* 细节在此不表；空链表将输出NULL */

List Merge( List L1, List L2 );

int main()
{
    List L1, L2, L;
    L1 = Read();
    L2 = Read();
    L = Merge(L1, L2);
    Print(L);
    Print(L1);
    Print(L2);
    return 0;
}

/* 你的代码将被嵌在这里 */
List Merge( List L1, List L2 )
{
    List result = (List)malloc(sizeof(struct Node));
    if (L1 == NULL)
    {
        result = L2;
        L2 = NULL;
        return result;
    }

    if (L2 == NULL)
    {
        result = L1;
        L1 = NULL;
        return result;
    }

    List p1 = List->Next,
         p2 = List->Next,
         tail = head->Next;

    while (p2 && p1)
    {
        tail = (PtrToNode)malloc(sizeof(struct Node));
        int p1_data = p1->Data, p2_data = p2->data;
        if (p1_data > p2_data)
        {
            tail->Data = p2_data;
            PtrToNode t = p2;
            p2 = p2->Next;
            free(t);
        }
        else
        {
            tail->Data = p1_data;
            PtrToNode t = p1;
            p1 = p1->Next;
            free(t);
        }
        tail = tail->Next;
    }
    while (p1)
    {
        tail = (PtrToNode)malloc(sizeof(struct Node));
        tail->Data = p1->Data;
        PtrToNode t = p1;
        p1 = p1->Next;
        free(t);
        tail = tail->Next;
    }
    while (p2)
    {
        tail = (PtrToNode)malloc(sizeof(struct Node));
        tail->Data = p2_data;
        PtrToNode t = p2;
        p2 = p2->Next;
        free(t);
        tail = tail->Next;
    }
    tail-Next = NULL;
    return result;

}
