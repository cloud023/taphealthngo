package com.conduit.taphealthngo.patient;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientFragmentPagerAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Health Information", "Medical History", "Prescriptions" };

    private Fragment patientFragmentTabs[] = new Fragment[] {
            PatientBasicInfoFragment.newInstance(),
            PatientMedicalHistoryFragment.newInstance() ,
            PatientBasicInfoFragment.newInstance() };

    private Context context;

    public PatientFragmentPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        return patientFragmentTabs[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
