You can find apk in the root folder

The libraries were used in this app:

1. Room
   Why Room?

Type Safety: Room provides a type-safe abstraction layer over SQLite, reducing the risk of runtime errors and improving code maintainability.
Simplified Database Operations: It handles common database tasks like queries, insertions, updates, and deletions, making database interactions more straightforward.
LiveData Integration: Room seamlessly integrates with LiveData, enabling automatic updates to your UI when database data changes, simplifying data synchronization.
Entity Validation: You can define validation rules for your entities, ensuring data integrity and preventing invalid data from being stored.
Alternatives and Why Room is Preferred:

Direct SQLite Usage: While possible, direct SQLite usage is more error-prone and requires more manual management of database transactions and updates.
Other ORMs: ORMs like SugarORM or GreenDAO exist, but Room offers a more comprehensive feature set, better integration with Android architecture components, and stronger community support.
2. Jetpack Compose
   Why Compose?

Declarative UI: Compose uses a declarative approach, where you describe the desired UI state, and the framework handles the rendering and updates. This leads to more concise and easier-to-understand code.
Interoperability: Compose can be gradually integrated into existing Android projects, allowing you to adopt it at your own pace.
Performance: Compose leverages the power of the Android UI toolkit and can often provide better performance than traditional XML-based layouts.
Theming and Styling: Compose offers a flexible theming system for customizing the appearance of your app, making it easier to maintain a consistent look and feel.
Alternatives and Why Compose is Preferred:

XML Layouts: While XML is still widely used, Compose offers a more modern and declarative approach, leading to more maintainable and reusable UI code.
Other Declarative UI Frameworks: Other frameworks like Flutter exist, but Compose is specifically designed for Android development and integrates seamlessly with other Android components.
3. Hilt
   Why Hilt?

Dependency Injection: Hilt provides a standard way to do dependency injection in Android apps, making it easier to manage dependencies and promote loose coupling between components.
Android-Specific Scoping: Hilt offers Android-specific scoping rules, such as ActivityScope and ViewModelScope, making it easy to manage the lifecycle of dependencies.
Integration with Architecture Components: Hilt integrates well with other Android Jetpack components, simplifying the process of setting up dependency injection in your app.
Reduced Boilerplate: Hilt can reduce the amount of boilerplate code required for dependency injection, making your code cleaner and more focused.
Ease of Use: For many developers, Hilt is easier to implement compared to custom solutions.
Alternatives and Why Hilt is Preferred:

Custom Dependency Injection: While it's possible to implement custom dependency injection solutions, Hilt provides a well-tested and widely adopted framework with built-in support for Android-specific features.
Other DI Frameworks: Other DI frameworks like Dagger exist, but Hilt is specifically designed for Android and offers better integration with Android architecture components.
4. Coroutines
   Why Coroutines?

Asynchronous Programming: Coroutines provide a structured way to write asynchronous code in Kotlin, making it easier to handle long-running tasks without blocking the main thread.
Cancellation and Timeouts: Coroutines support cancellation and timeouts, allowing you to gracefully handle tasks that take too long or are no longer needed.
Interoperability: Coroutines can be used with other asynchronous programming models, such as RxJava, making it easier to integrate with existing codebases.
Improved Readability: Coroutines can often lead to more readable and maintainable code compared to traditional callback-based approaches.
Alternatives and Why Coroutines are Preferred:

Callbacks: While callbacks are still used, coroutines offer a more structured and less error-prone way to write asynchronous code.
RxJava: RxJava is another popular choice for reactive programming, but coroutines provide a more Kotlin-native approach and can be easier to learn for developers familiar with Kotlin's syntax.

