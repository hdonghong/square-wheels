#include <stdio.h>
#include <stdlib.h>

#define MAXSIZE 10
#define NotFound 0
typedef int ElementType;

typedef int Position;
typedef struct LNode *List;
struct LNode {
    ElementType Data[MAXSIZE];
    Position Last; /* �������Ա������һ��Ԫ�ص�λ�� */
};

List ReadInput(); /* ����ʵ�֣�ϸ�ڲ���Ԫ�ش��±�1��ʼ�洢 */
Position BinarySearch( List L, ElementType X );

int main()
{
    List L;
    ElementType X;
    Position P;

    L = ReadInput();
    scanf("%d", &X);
    P = BinarySearch( L, X );
    printf("%d\n", P);

    return 0;
}
List ReadInput() {
    return NULL;
}

/* ��Ĵ��뽫��Ƕ������ */
/*
    ���룺
    5
    12 31 55 89 101
    31
    �����
    2

    ���룺
    3
    26 78 233
    31
    �����
    0
*/
Position BinarySearch( List L, ElementType X ) {
    if (L == NULL || L->Last == 0) {
        return NotFound;
    }
    int left = 1;
    int right = L->Last;
    while (left <= right) {
        int mid = (left + right) >> 1;
        if (X > L->Data[mid]) {
            left = mid + 1;
        } else if (X < L->Data[mid]) {
            right = mid - 1;
        } else {
            return mid;
        }
    }
    return NotFound;
}
