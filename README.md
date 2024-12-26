# Selenium Cucumber Java Project

Ini adalah proyek pengujian otomatisasi menggunakan Selenium dengan framework Cucumber berbasis Java. Proyek ini memungkinkan Anda mengotomatisasi pengujian aplikasi berbasis web dengan pendekatan BDD (Behavior-Driven Development).

## Prasyarat

Sebelum memulai, pastikan Anda sudah menginstal:

- Java Development Kit (JDK) (versi 20 atau lebih baru disarankan)

- Maven (untuk pengelolaan dependensi)

- IntelliJ IDEA atau editor teks lain yang mendukung Java


## Instalasi

Clone repositori ini ke komputer lokal Anda:


1. Clone repositori ini ke komputer lokal Anda:

    ```bash
    git clone https://github.com/ekaferdyan/selenium-cucumber-java.git
    ```

2. Pastikan semua dependensi yang didefinisikan di file pom.xml diunduh dengan menjalankan perintah berikut:

    ```bash
    mvn clean install
    ```

## Menjalankan Pengujian

1.  Jalankan perintah berikut untuk menjalankan semua pengujian:

    ```bash
    mvn test
    ```

2. Menjalankan pengujian spesifik menggunakan tag Cucumber untuk menjalankan pengujian tertent:
    ```bash
    mvn test -Dcucumber.options="--tags @tagname"
    ```

## Membuat Pengujian Baru

1.  Tambahkan skenario baru di file .feature yang sesuai di folder src/test/features.

2.  Implementasikan langkah-langkah skenario tersebut di file step definitions di folder src/test/java/stepDefinition.

3.  Jalankan pengujian untuk memastikan semua skenario berhasil.