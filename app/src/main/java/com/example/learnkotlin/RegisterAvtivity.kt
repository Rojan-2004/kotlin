package com.example.learnkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.learnkotlin.ui.theme.learnkotlinTheme
import java.util.Calendar

@Composable
fun Registration(innerPadding: PaddingValues) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var selectedCountry by remember { mutableStateOf("Select Country") }
    var countryDropdownExpanded by remember { mutableStateOf(false) }
    var dob by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") } // Gender state
    var termsAccepted by remember { mutableStateOf(false) } // Terms state

    val countries = listOf("Select Country", "USA", "India", "UK", "Canada")

    // For Date Picker


    var showDatePickerDialog by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // Date Picker Dialog Logic
    if (showDatePickerDialog) {
        DatePickerDialog(
            LocalContext.current,
            { _, selectedYear, selectedMonth, selectedDay ->
                dob = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            },
            year,
            month,
            day
        ).show()
        showDatePickerDialog = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Register",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("Firstname") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Lastname") },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Country Dropdown with custom drawable icon
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = selectedCountry,
                onValueChange = { },
                label = { Text("Select Country") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { countryDropdownExpanded = !countryDropdownExpanded },
                readOnly = true,
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                        contentDescription = "Dropdown icon",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { countryDropdownExpanded = !countryDropdownExpanded }
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // DOB Field with Date Picker
        OutlinedTextField(
            value = dob,
            onValueChange = { },
            label = { Text("Date of Birth") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    showDatePickerDialog = true
                },
            readOnly = true
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Gender",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

// Gender Radio Buttons with aligned labels
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = gender == "Male",
                    onClick = { gender = "Male" }
                )
                Text(text = "Male", modifier = Modifier.padding(end = 16.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = gender == "Female",
                    onClick = { gender = "Female" }
                )
                Text(text = "Female", modifier = Modifier.padding(end = 16.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = gender == "Other",
                    onClick = { gender = "Other" }
                )
                Text(text = "Other")
            }
        }



        Spacer(modifier = Modifier.height(16.dp))

        // You can add the Submit button here if you want to finalize the form
        Button(
            onClick = { /* Handle form submission */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = termsAccepted // Only enable if terms are accepted
        ) {
            Text(text = "Submit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "Already have an account? ")
            Text(
                text = "Sign in",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    // Handle navigation to Sign In screen
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistration() {
    Registration(innerPadding = PaddingValues(0.dp))
}