package labs.gecko.where;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by punkah on 11/5/2016.
 */
@RunWith(AndroidJUnit4.class)
public class SearchFieldActivityTest {
    @Rule
    public ActivityTestRule<SearchFieldActivity> activityTestRule = new ActivityTestRule<SearchFieldActivity>(SearchFieldActivity.class);

    @Test
    public void search() {
        Espresso.onView(ViewMatchers.withId(R.id.searchText)).perform(ViewActions.replaceText("cafe"), ViewActions.pressKey(KeyEvent.KEYCODE_ENTER));
//        Espresso.onData(CoreMatchers.anything())
//                .inAdapterView(ViewMatchers.withId(R.id.resultList))
//                .check(ViewAssertions.matches(ViewMatchers.withText("Verve Cafe")));
    }
}