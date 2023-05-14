package MatchMeetingTimes;

import java.util.ArrayList;
import java.util.List;

public class SimpleMatchMeetingTimes {
    public static void main(String[] args) {
        String[] person1MeetingTimes = {"9:00-10:30", "12:00-13:00", "16:00-18:00"};
        String[] person2MeetingTimes = {"10:00-11:30", "12:30-14:30", "14:30-15:00", "16:00-17:00"};
        String[] matchingMeetingTimes = matchMeetingTimes(person1MeetingTimes, person2MeetingTimes);
        printMeetingTimes(matchingMeetingTimes);
    }

    // Assumptions:
    // - Meeting times are in 24-hour format
    // - Meeting times are in 30-minute intervals
    // - Meeting times are in ascending order
    // - Meeting times are non-overlapping
    // - Meeting times are non-empty
    public static String[] matchMeetingTimes(String[] person1MeetingTimes, String[] person2MeetingTimes) {
        // Parse meeting times
        float[][] person1ParsedMeetingTimes = parseMeetingTimes(person1MeetingTimes);
        float[][] person2ParsedMeetingTimes = parseMeetingTimes(person2MeetingTimes);

        // Find matching intervals
        List<float[]> matchingIntervals = new ArrayList<>();
        for (float[] person1Interval : person1ParsedMeetingTimes) {
            for (float[] person2Interval : person2ParsedMeetingTimes) {
                if (!(person1Interval[0] >= person2Interval[1] || person1Interval[1] <= person2Interval[0])) {
                    float[] matchingInterval = computeMatchingInterval(person1Interval, person2Interval);
                    matchingIntervals.add(matchingInterval);
                }
            }
        }

        return formatMatchingIntervals(matchingIntervals);
    }

    private static float[][] parseMeetingTimes(String[] meetingTimes) {
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
        return parsedMeetingTimes;
    }

    private static float[] computeMatchingInterval(float[] interval1, float[] interval2) {
        float[] matchingInterval = new float[2];
        // Find the latest start time
        matchingInterval[0] = Math.max(interval1[0], interval2[0]);
        // Find the earliest end time
        matchingInterval[1] = Math.min(interval1[1], interval2[1]);
        return matchingInterval;
    }

    private static String[] formatMatchingIntervals(List<float[]> matchingIntervals) {
        // Format matching intervals
        String[] matchingMeetingTimes = new String[matchingIntervals.size()];
        for (int i = 0; i < matchingIntervals.size(); i++) {
            float[] matchingInterval = matchingIntervals.get(i);
            String matchingMeetingTime = String.format(
                "%.0f:%02.0f-%.0f:%02.0f", 
                Math.floor(matchingInterval[0]), (matchingInterval[0] % 1) * 60, 
                Math.floor(matchingInterval[1]), (matchingInterval[1] % 1) * 60
            );
            matchingMeetingTimes[i] = matchingMeetingTime;
        }
        return matchingMeetingTimes;
    }

    public static void printMeetingTimes(String[] meetingTimes) {
        for (String meetingTime : meetingTimes) {
            System.out.println(meetingTime);
        }
    }
}