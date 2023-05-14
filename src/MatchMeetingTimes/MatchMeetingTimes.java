package MatchMeetingTimes;

public class MatchMeetingTimes {
    public static void main(String[] args) {
        String[] person1MeetingTimes = {"9:00-10:30", "12:00-13:00", "16:00-18:00"};
        String[] person2MeetingTimes = {"10:00-11:30", "12:30-14:30", "14:30-15:00", "16:00-17:00"};

        printMeetingTimes(matchMeetingTimes(person1MeetingTimes, person2MeetingTimes));
    }

    public static String[] matchMeetingTimes(String[] person1MeetingTimes, String[] person2MeetingTimes) {
        float[][] person1ParsedMeetingTimes = new float[person1MeetingTimes.length][2];
        float[][] person2ParsedMeetingTimes = new float[person2MeetingTimes.length][2];

        for (int i = 0; i < person1MeetingTimes.length; i++) {
            String[] person1MeetingTime = person1MeetingTimes[i].split("-");
            float[] person1ParsedMeetingTime = new float[2];
            for (int j = 0; j < 2; j++) {
                person1ParsedMeetingTime[j] = Float.parseFloat(person1MeetingTime[j].split(":")[0]);
                person1ParsedMeetingTime[j] += Float.parseFloat(person1MeetingTime[j].split(":")[1]) / 60;
            }

            person1ParsedMeetingTimes[i] = person1ParsedMeetingTime;
        }

        for (int i = 0; i < person2MeetingTimes.length; i++) {
            String[] person2MeetingTime = person2MeetingTimes[i].split("-");
            float[] person2ParsedMeetingTime = new float[2];
            for (int j = 0; j < 2; j++) {
                person2ParsedMeetingTime[j] = Float.parseFloat(person2MeetingTime[j].split(":")[0]);
                person2ParsedMeetingTime[j] += Float.parseFloat(person2MeetingTime[j].split(":")[1]) / 60;
            }

            person2ParsedMeetingTimes[i] = person2ParsedMeetingTime;
        }

        float[][] matchingIntervals = new float[person1ParsedMeetingTimes.length + person2ParsedMeetingTimes.length][2];
        int intervalCounter = 0;

        for (float[] person1Interval : person1ParsedMeetingTimes) {
            for (float[] person2Interval : person2ParsedMeetingTimes) {
                if (intervalCounter < matchingIntervals.length && !(person1Interval[0] >= person2Interval[1] || person1Interval[1] <= person2Interval[0])) {
                    matchingIntervals[intervalCounter][0] = Math.max(person1Interval[0], person2Interval[0]);
                    matchingIntervals[intervalCounter][1] = Math.min(person1Interval[1], person2Interval[1]);
                    intervalCounter++;
                }
            }
        }

        String[] matchingMeetingTimes = new String[intervalCounter];

        for (int i = 0; i < intervalCounter; i++) {
            String matchingMeetingTime = "";
            for (int j = 0; j < 2; j++) {
                int hour = (int) matchingIntervals[i][j];
                int minute = (int) ((matchingIntervals[i][j] - hour) * 60);
                matchingMeetingTime += hour + ":" + minute;
                if (minute == 0) {
                    matchingMeetingTime += "0";
                }
                if (j == 0) {
                    matchingMeetingTime += "-";
                }
            }

            matchingMeetingTimes[i] = matchingMeetingTime;
        }

        return matchingMeetingTimes;
    }

    public static void printMeetingTimes(String[] meetingTimes) {
        for (int i = 0; i < meetingTimes.length; i++) {
            System.out.println(meetingTimes[i]);
        }
    }

    public static void parseMeetingTimes(String[] meetingTimes) {
        float[][] parsedMeetingTimes = new float[meetingTimes.length][2];

        for (int i = 0; i < meetingTimes.length; i++) {
            String[] meetingTime = meetingTimes[i].split("-");
            float[] parsedMeetingTime = new float[2];
            for (int j = 0; j < 2; j++) {
                parsedMeetingTime[j] = Float.parseFloat(meetingTime[j].split(":")[0]);
                parsedMeetingTime[j] += Float.parseFloat(meetingTime[j].split(":")[1]) / 60;
            }

            parsedMeetingTimes[i] = parsedMeetingTime;
        }
    }
}