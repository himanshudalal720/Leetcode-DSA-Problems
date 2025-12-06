1class Solution {
2    public int countPartitions(int[] nums, int k) {
3        long dp[]=new long[nums.length];
4        dp[0]=1l;
5        long sum=1l;
6        ArrayList<Integer> l=new ArrayList<Integer>();
7        l.add(nums[0]);
8        int start=0;
9        for(int i=1;i<nums.length;i++)
10        {
11            int low=0,high=l.size()-1;
12            while(low<=high)
13            {
14                int mid=(low+high)/2;
15                if(l.get(mid)>nums[i])
16                {
17                    high=mid-1;
18                }
19                else
20                {
21                    low=mid+1;
22                }
23            }
24            l.add(low,nums[i]);
25            while(l.size()>1 && l.get(l.size()-1)-l.get(0)>k)
26            {
27                 low=0;
28                 high=l.size()-1;
29                 while(low<=high)
30                 {
31                    int mid=(low+high)/2;
32                    if(l.get(mid)==nums[start])
33                    {
34                        l.remove(mid);
35                        if(dp[start]>sum)
36                        {
37                            sum=sum+(1000000007);
38                        }
39                        sum=sum-dp[start];
40                        break;
41                    }
42                    if(l.get(mid)>nums[start])
43                    {
44                        high=mid-1;
45                    }
46                    else
47                    {
48                        low=mid+1;
49                    }
50                 }
51                 start++;
52            }
53            if(l.size()==1)
54            {
55                 dp[i]=dp[i-1];
56                 sum=dp[i];
57            }
58            else
59            {
60                if(start==0)
61                {
62                    dp[i]=sum+1l;
63                    sum=sum+dp[i];
64                }
65                else
66                {
67                    dp[i]=sum+dp[start-1];
68                    sum=sum+dp[i];
69                }
70            }
71            dp[i]=dp[i]%(1000000007);
72            sum=sum%1000000007;
73        }
74        return (int)(dp[dp.length-1]);
75    }
76}