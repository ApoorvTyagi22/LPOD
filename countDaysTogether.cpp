class Solution {
public:
    int daysInMonth[13] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int getDayOfYear(string date){
        int month = stoi(date.substr(0, 2));
        int day = stoi(date.substr(3));

        int totalDays = day; 
        for(int i = 0; i < month - 1; i++){
            totalDays += daysInMonth[i];
        }

        return totalDays; 
    }

    int countDaysTogether(string arriveAlice, string leaveAlice, string arriveBob, string leaveBob) {
        int aliceStart = getDayOfYear(arriveAlice);
        int aliceEnd = getDayOfYear(leaveAlice);
        int bobStart = getDayOfYear(arriveBob);
        int bobEnd = getDayOfYear(leaveBob);

        int overlapStart = max(aliceStart, bobStart);
        int overlapEnd = min(aliceEnd, bobEnd);


        return max(0, overlapEnd - overlapStart + 1);      
    }
};