plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.planifica_vacaciones"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.planifica_vacaciones"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


    dependencies {

        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.activity:activity-compose:1.8.1")
        implementation(platform("androidx.compose:compose-bom:2023.03.00"))
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-graphics")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
        androidTestImplementation("androidx.compose.ui:ui-test-junit4")
        debugImplementation("androidx.compose.ui:ui-tooling")
        debugImplementation("androidx.compose.ui:ui-test-manifest")

        ksp("com.google.devtools.ksp:symbol-processing-api:1.8.10-1.0.9")

        //Navigation
        implementation("androidx.navigation:navigation-compose:2.7.5")

        // ViewModel en Compose
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

        //CameraX
        val camerax_version = "1.2.3"
        implementation("androidx.camera:camera-core:${camerax_version}")
        implementation("androidx.camera:camera-camera2:${camerax_version}")
        implementation("androidx.camera:camera-lifecycle:${camerax_version}")
        implementation("androidx.camera:camera-view:${camerax_version}")

        //Para determinar ubicacion
        implementation("com.google.android.gms:play-services-location:21.0.1")

        // Open Street Map (osmdroid)
        implementation("org.osmdroid:osmdroid-android:6.1.16")

        // ROOM
        val room_version = "2.5.2"
        implementation("androidx.room:room-runtime:$room_version")
        annotationProcessor("androidx.room:room-compiler:$room_version")
        ksp("androidx.room:room-compiler:$room_version")
        implementation("androidx.room:room-ktx:$room_version")

        // retrofit permite consumir web service en base al protocolo http
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
        implementation ("com.squareup.moshi:moshi-kotlin:1.13.0")

        //coil a partir de una url es capaz de utilizar una imagen en el proyecto
        implementation("io.coil-kt:coil-compose:2.4.0")
    }
}
dependencies {
    implementation("androidx.recyclerview:recyclerview:1.3.2")
}
