package cgeo.geocaching;

import cgeo.geocaching.activity.AbstractActivity;
import cgeo.geocaching.utils.Version;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AbstractActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme();
        setContentView(R.layout.about_activity);
        setTitle(res.getString(R.string.about));

        ((TextView) findViewById(R.id.about_version_string)).setText(Version.getVersionName(this));
        ((TextView) findViewById(R.id.contributors)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) findViewById(R.id.changelog)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * @param view
     *            unused here but needed since this method is referenced from XML layout
     */
    public void donate(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=FMLNN8GXZKJEE")));
    }

    /**
     * @param view
     *            unused here but needed since this method is referenced from XML layout
     */
    public void support(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:george@ruinelli.ch")));
    }

    /**
     * @param view
     *            unused here but needed since this method is referenced from XML layout
     */
    public void website(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ruinelli.ch/cgeo")));
    }

    /**
     * @param view
     *            unused here but needed since this method is referenced from XML layout
     */
    public void facebook(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/pages/cgeo/297269860090")));
    }

    /**
     * @param view
     *            unused here but needed since this method is referenced from XML layout
     */
    public void twitter(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/android_gc")));
    }

    /**
     * @param view
     *            unused here but needed since this method is referenced from XML layout
     */
    public void nutshellmanual(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cgeo.org/")));
    }
}
