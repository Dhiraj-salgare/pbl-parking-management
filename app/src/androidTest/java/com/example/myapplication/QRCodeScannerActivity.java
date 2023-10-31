
package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.journeyapps.barcodescanner.CaptureActivity;


public class QRCodeScannerActivity extends CaptureActivity {
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 0) {
            if (resultCode == RESULT_OK && data != null) {
                String scannedData = data.getStringExtra("SCAN_RESULT"); // Get the scanned data
                // Parse and process the scanned data (e.g., extract name, age, school)


            }
        }
    }
}
