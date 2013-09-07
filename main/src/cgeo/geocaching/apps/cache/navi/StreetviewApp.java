package cgeo.geocaching.apps.cache.navi;

import cgeo.geocaching.R;
import cgeo.geocaching.cgeoapplication;
import cgeo.geocaching.activity.ActivityMixin;
import cgeo.geocaching.geopoint.Geopoint;
import cgeo.geocaching.utils.ProcessUtils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

class StreetviewApp extends AbstractPointNavigationApp {

    private static final String PACKAGE_NAME_STREET_VIEW = "com.google.android.street";
    private static final boolean INSTALLED = ProcessUtils.isInstalled(PACKAGE_NAME_STREET_VIEW);

    StreetviewApp() {
        super(getString(R.string.cache_menu_streetview), null);
    }

    @Override
    public boolean isInstalled() {
        return INSTALLED;
    }

    @Override
    public void navigate(Activity activity, Geopoint point) {
        try {
            activity.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("google.streetview:cbll=" + point.getLatitude() + "," + point.getLongitude())));
        } catch (final ActivityNotFoundException e) {
            ActivityMixin.showToast(activity, cgeoapplication.getInstance().getString(R.string.err_application_no));
        }
    }
}