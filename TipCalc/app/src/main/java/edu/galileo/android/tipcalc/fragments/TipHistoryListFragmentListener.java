package edu.galileo.android.tipcalc.fragments;


import edu.galileo.android.tipcalc.models.TipRecord;

public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();


}
