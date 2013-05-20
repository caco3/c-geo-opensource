package cgeo.geocaching.activity;

import cgeo.geocaching.cgeoapplication;
import cgeo.geocaching.compatibility.Compatibility;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentListActivity;
import android.view.View;

public abstract class AbstractListActivity extends FragmentListActivity implements
        IAbstractActivity {

    private String helpTopic;
    private boolean keepScreenOn = false;

    protected cgeoapplication app = null;
    protected Resources res = null;

    protected AbstractListActivity() {
        this(null);
    }

    protected AbstractListActivity(final boolean keepScreenOn) {
        this(null);
        this.keepScreenOn = keepScreenOn;
    }

    protected AbstractListActivity(final String helpTopic) {
        this.helpTopic = helpTopic;
    }

    @Override
    final public void goHome(View view) {
        ActivityMixin.goHome(this);
    }

    final public void showProgress(final boolean show) {
        ActivityMixin.showProgress(this, show);
    }

    final public void setTheme() {
        ActivityMixin.setTheme(this);
    }

    @Override
    public final void showToast(String text) {
        ActivityMixin.showToast(this, text);
    }

    @Override
    public final void showShortToast(String text) {
        ActivityMixin.showShortToast(this, text);
    }

    @Override
    public final void helpDialog(final String title, final String message) {
        ActivityMixin.helpDialog(this, title, message, null);
    }

    public final void helpDialog(final String title, final String message, final Drawable icon) {
        ActivityMixin.helpDialog(this, title, message, icon);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init
        res = this.getResources();
        app = (cgeoapplication) this.getApplication();

        ActivityMixin.keepScreenOn(this, keepScreenOn);
    }

    final public void setTitle(final String title) {
        ActivityMixin.setTitle(this, title);
    }

    @Override
    public void invalidateOptionsMenuCompatible() {
        Compatibility.invalidateOptionsMenu(this);
    }
}
