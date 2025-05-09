How to To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root settings.gradle at the end of repositories:

dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
Step 2. Add the dependency

[![](https://jitpack.io/v/alphatech-apps/PlayStoreMain.svg)](https://jitpack.io/#alphatech-apps/PlayStoreMain)

dependencies {
	        implementation 'com.github.alphatech-apps:PlayStoreMain:Tag'
}
Step 3. add on Remote class


public class DoRemoteJob {
    Context context;

    public DoRemoteJob(Context context) {
        this.context = context;

        PlayStore_updateFromPlayStore(context);
        PlayStore_tryOurOtherAppsLoad(context);
        PlayStore_RateUs(context);
    }

    private void PlayStore_updateFromPlayStore(Context context) {
        new PlayStore_Update(context);
    }

    private void PlayStore_tryOurOtherAppsLoad(Context context) {
        String developerName = context.getString(R.string.developerName);
        new PlayStore_TryOurApps(context, developerName, 2);
    }

    private void PlayStore_RateUs(Context context) {
        new PlayStore_RateUs(context, Calendar.FRIDAY);
    }
}
