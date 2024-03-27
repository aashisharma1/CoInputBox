# CoInputBox

CoInputBox is a library designed to facilitate the creation of custom input formats for Android EditTexts. With CoInputBox, you can easily add custom signs at specific indices within an EditText to enforce a certain format, such as vehicle number plates, phone numbers, or any other custom input pattern.

## Features

- Allows adding custom signs at specific indices in EditTexts.
- Enables enforcing specific formats for user input.
- Simple to integrate and use within your Android projects.

## Usage

### 1. Add the JitPack repository to your build file

```gradle 
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}

```

2. Add the dependency
```
	dependencies {
	        implementation 'com.github.aashisharma1:CoInputBox:Tag'
	}

```
## for example 

```
val maxPlateLength = 13 // Total length 
val separatorIndices = listOf(1, 3, 5) // Indexes where you want to enter the separator sign
val sign = '-' // Separator sign

val textWatcher = DevelopTextWatcher(editText, maxPlateLength, separatorIndices, sign)
editText.addTextChangedListener(textWatcher)  // Set on EditText
```


# Contributions
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or create a pull request.

