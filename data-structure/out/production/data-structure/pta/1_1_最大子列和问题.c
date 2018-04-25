#include <stdio.h>
#include <stdlib.h>

int a[100000];

int main()
{
    int n;
    scanf("%d", &n);
    if (n == 0) return 0;
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    int curr_max = a[0], result = a[0];
    for (int i = 1; i < n; i++)
    {
        curr_max = max(curr_max+a[i], a[i]);
        result = max(curr_max, result);
    }

    printf("%d", result < 0 ? 0 : result);
    return 0;
}
int max(int a, int b)
{
    return a > b ? a : b;
}
