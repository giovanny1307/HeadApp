package headapp.digitalexperiences.com.headapp.notificationJob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class NotificationJobCreator implements JobCreator {
    @Nullable
    @Override
    public Job create(@NonNull String tag) {
        switch (tag) {
            case MessageNotificationJob.TAG:
                return new MessageNotificationJob();
             default:
                 return null;
        }
    }
}
