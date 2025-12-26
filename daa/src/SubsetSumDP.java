import java.util.Scanner;

public class SubsetSumDP 
{
    public static boolean subsetSum(int[] arr, int target) 
    {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) 
        {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) 
        {
            for (int j = 1; j <= target; j++) 
            {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) 
                {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Masukkan elemen-elemen array:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Masukkan nilai target: ");
        int target = sc.nextInt();

        boolean result = subsetSum(arr, target);

        System.out.println("=== Hasil Akhir ===");
        if (result) 
        {
            System.out.println("Subset dengan jumlah " + target + " ditemukan.");
        } 
        else 
        {
            System.out.println("Tidak ada subset dengan jumlah " + target + ".");
        }

        sc.close();
    }
}
