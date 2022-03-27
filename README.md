# Why Datastore?
- There are many benefits of using data store over shared preferences but a few that will take your attention are:
- Shared preferences are synchronous and run on the main thread, while datastore runs on a separate thread which makes it thread-safe
- Datastore is relatively easy to use as compared to shared preferences and uses a kotlin first approach.
- Async API for storing and reading the data (Flow)
- Safe to call from UI thread (Dispatchers.IO underneath)
- Shared preferences had no mechanism for signalling errors, lack of transactional API, while datastore stores data asynchronously with consistency and transaction support.
- DataStore is a replacement for SharedPreferences that addresses most of the shortcomings that shared preferences had.