[![](https://jitpack.io/v/alphatech-apps/PlayStoreMain.svg)](https://jitpack.io/#alphatech-apps/PlayStoreMain)


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

dependencies {
	        implementation 'com.github.alphatech-apps:PlayStoreMain:Tag'
}
Step 3. add on Remote class
