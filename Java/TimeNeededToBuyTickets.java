package Java;


public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int []tickets = {2, 3, 2, 1};
        int k = 1;
        int timeRequiredToBuy = timeRequiredToBuy(tickets, k);
        System.out.println("timeRequiredToBuy : "+timeRequiredToBuy);
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int c = 0; c < tickets.length; c++){
            if (c <= k){
                time = time + Math.min(tickets[c], tickets[k]);
            }
            else {
                time = time + Math.min(tickets[c], tickets[k]-1);
            }
        }
        return time;
    }
}
