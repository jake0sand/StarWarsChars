# StarWarsChars

--------------*Technologies/ libraries Utilised*--------------

- MVVM Architecture

- Single Activity w/ Fragments

- Kotlin Coroutines

- Kotlin Flows

- Pagination with Paging 3

- Dependency Injection w/ Dagger Hilt

- Retrofit API Networking

- JSON Parsing w/ Moshi

- Cached Data for offline usage

- 100% Kotlin

- Domain Models for better Architecture

- Merging multiple data sources

- Coil for Image Loading with Coroutines 

- WebView for browsing internet within app.

- Android Jetpack
  - Paging 3 with beautiful continuous scroll
  - Constraint Layout
  - Fragments
  - LiveData
  - ViewBinding
  - RecyclerView
    - StaggeredGridLayoutManager
  - Constraint Layout
  - Navigation Component
  - SafeArgs

        // Retrofit
        implementation 'com.squareup.retrofit2:retrofit:2.9.0'
        implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'
        implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.3"
        implementation("com.squareup.moshi:moshi-kotlin:1.13.0")

        // Coroutines
        implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0'
        implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0'

        // Coroutine Lifecycle Scopes
        implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
        implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"

        //dagger-hilt
        implementation("com.google.dagger:hilt-android:2.40.5")
        kapt("com.google.dagger:hilt-android-compiler:2.40.5")
        implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"

        // Navigation
        def nav_version = "2.4.2"

        // Kotlin
        implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
        implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

        // Paging
        def paging_version = "3.1.1"

        implementation "androidx.paging:paging-runtime:$paging_version"

        //coil
        implementation("io.coil-kt:coil:1.4.0")

