/*
 * Copyright 2018 EvilCorpCode & original author Phillip Hsu
 *
 * This file is part of TheSmartClock.
 *
 * TheSmartClock is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TheSmartClock is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TheSmartClock.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.evilcorpcode.thesmartclock;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Phillip Hsu on 6/30/2016.
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;

    /**
     * Required empty public constructor. Subclasses do not
     * need to implement their own.
     */
    public BaseFragment() {
    }

    /**
     * @return the layout resource for this Fragment
     */
    @LayoutRes
    protected abstract int contentLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(contentLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Only need to unbind for fragments! Activities etc handle themselves
        unbinder.unbind();
    }

    /**
     * Callback invoked when this Fragment is part of a ViewPager and it has been
     * selected, as indicated by {@link android.support.v4.view.ViewPager.OnPageChangeListener#onPageSelected(int)
     * onPageSelected(int)}.
     */
    public void onPageSelected() {
        // TODO: Consider making this abstract. The reason it wasn't abstract in the first place
        // is not all Fragments in our ViewPager need to do things upon being selected. As such,
        // those Fragments' classes would just end up stubbing this implementation.
    }
}
