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
    int first = 0, last = 0;
    for (int i = 1; i < n; i++)
    {
        if (curr_max+a[i] > a[i])
        {
            curr_max += a[i];
        }
        else
        {
            curr_max = a[i];
        }

        if (curr_max > result)
        {
            result = curr_max;
            last = i;
            first++;
        }
    }

    if (result >= 0)
        if (n > 1)
            printf("%d %d %d", result, a[last-first+1], a[last]);
        else
            printf("%d %d %d", result, a[first], a[last]);
    else
        printf("%d %d %d", 0, a[0], a[n-1]);
    return 0;
}
