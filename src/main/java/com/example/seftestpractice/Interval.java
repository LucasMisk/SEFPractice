package com.example.seftestpractice;

public class Interval {
    int start;
    int end;
    Paranthesis pstart;
    Paranthesis pend;

    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Paranthesis getPstart() {
        return pstart;
    }

    public void setPstart(Paranthesis pstart) {
        this.pstart = pstart;
    }

    public Paranthesis getPend() {
        return pend;
    }

    public void setPend(Paranthesis pend) {
        this.pend = pend;
    }

    public Interval(int start, int end, Paranthesis pstart, Paranthesis pend) {
        this.start = start;
        this.end = end;
        this.pstart = pstart;
        this.pend = pend;
    }

    public int[] create()
    {
        if(start > end || end -start < 2)
            throw new InvalidValuesForIntervalException("Error at interval values");
        if(pstart == Paranthesis.OPEN && pend == Paranthesis.OPEN)
            return new int[]{start + 1, end - 1};
        else if(pstart == Paranthesis.OPEN && pend == Paranthesis.CLOSED)
            return new int[]{start + 1, end};
        else if(pstart == Paranthesis.CLOSED && pend == Paranthesis.OPEN)
            return new int[]{start, end-1};
        else
            return new int[]{start, end};
    }

    public boolean Contains(int number)
    {
        int[] limits = create();
        if(number >= limits[0] && number <= limits[1])
            return true;
        return false;
    }
}
