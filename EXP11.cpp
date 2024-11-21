#include <iostream>
#include <string>
#include <cmath>
#include <sstream>
using namespace std;

// Function to display the main menu for choosing number systems
void mainMenu() {
    cout << "[1] Binary Number System" << endl;
    cout << "[2] Octal Number System" << endl;
    cout << "[3] Decimal Number System" << endl;
    cout << "[4] Hexadecimal Number System" << endl;
    cout << "Enter your option :";
}

// Function to check if the input number matches the number system's radix
bool checkNumberSystem(const string& num, const int& radix) {
    // Binary number system check
    if (radix == 2) {
        for (char digit : num) {
            if (digit != '0' && digit != '1' && digit != '.') {
                return false; // Number is invalid if it contains digits other than 0, 1, or '.'
            }
        }
    }
    // Octal number system check
    else if (radix == 8) {
        for (char digit : num) {
            if ((digit < '0' || digit > '7') && digit != '.') {
                return false; // Number is invalid if it contains digits outside 0-7 or '.'
            }
        }
    }
    // Decimal number system check
    else if (radix == 10) {
        for (char digit : num) {
            if (!isdigit(digit) && digit != '.') {
                return false; // Number is invalid if it contains non-digit characters and not '.'
            }
        }
    }
    // Hexadecimal number system check
    else {
        for (char digit : num) {
            if (!isdigit(digit) && (toupper(digit) < 'A' || toupper(digit) > 'F') && digit != '.') {
                return false; // Number is invalid if it contains digits outside 0-9, A-F, or '.'
            }
        }
    }
    return true; // Valid number if no errors found
}

// Function to convert a number from any radix to decimal (base 10)
long double toDecimal(const string& num, int radix) {
    long double decimalValue = 0;  // Stores the converted decimal value
    bool isFraction = false;       // To identify if we're processing the fractional part
    int exp = 0;                   // Exponent for fractional part calculation

    // Process each character of the input number
    for (int i = 0; i < num.length(); i++) {
        char digit = toupper(num[i]);  // Handle both upper and lower case for hexadecimal

        // Handle fractional part
        if (digit == '.') {
            isFraction = true;
            continue;  // Skip processing for the decimal point itself
        }

        // Convert digit to its numerical value
        int intValue = (isdigit(digit)) ? digit - '0' : digit - 'A' + 10;

        // Process the integer part (before the decimal point)
        if (!isFraction) {
            decimalValue = decimalValue * radix + intValue;
        }
        // Process the fractional part (after the decimal point)
        else {
            exp--;
            decimalValue += intValue * pow(radix, exp);
        }
    }

    return decimalValue;  // Return the decimal (base 10) value
}

// Function to convert a decimal number to any higher radix (binary, octal, hexadecimal)
string fromDecimal(long double decimal, int radix) {
    long long intPart = static_cast<long long>(decimal);  // Get the integer part of the number
    long double fracPart = decimal - intPart;             // Get the fractional part of the number

    string result = "";  // Stores the converted result in the target radix
    if (intPart == 0) result = "0";  // If the integer part is 0, set result to "0"

    // Convert the integer part to the target radix
    while (intPart > 0) {
        int rem = intPart % radix;  // Get the remainder (digit in the target radix)
        result = (rem > 9 ? char(rem - 10 + 'A') : char(rem + '0')) + result;
        intPart /= radix;  // Reduce the integer part by dividing by radix
    }

    // Convert the fractional part to the target radix (up to 5 decimal places)
    if (fracPart > 0.0) {
        result += ".";
        int count = 0;  // Limit to a precision of 5 decimal places
        while (fracPart > 0.0 && count < 5) {
            fracPart *= radix;  // Multiply fractional part by radix
            int digit = static_cast<int>(fracPart);  // Get the next digit
            result += (digit > 9 ? char(digit - 10 + 'A') : char(digit + '0'));
            fracPart -= digit;  // Remove the processed digit from the fractional part
            count++;
        }
    }

    return result;  // Return the final converted number in the target radix
}

// Convert number from a lower radix to a higher radix
string lowerToHigherRadix(const string& num, const int& fromRadix, const int& toRadix) {
    long double decimalValue = toDecimal(num, fromRadix);  // First convert to decimal
    return fromDecimal(decimalValue, toRadix);  // Then convert decimal to the target radix
}

// Convert number from a higher radix to a lower radix
string higherToLowerRadix(const string& num, const int& fromRadix, const int& toRadix) {
    long double decimalValue = toDecimal(num, fromRadix);  // First convert to decimal
    return fromDecimal(decimalValue, toRadix);  // Then convert decimal to the target radix
}

int main() {
    int fromRadix, toRadix;  // Stores the radix of the source and target number systems
    string num, result;      // Stores the input number and the conversion result

    // Ask the user to choose the number system of their input
    cout << "Choose the number system of your number : " << endl;
    mainMenu();
    cin >> fromRadix;

    // Convert the menu choice to the corresponding radix
    switch (fromRadix) {
    case 1:
        fromRadix = 2;   // Binary
        break;
    case 2:
        fromRadix = 8;   // Octal
        break;
    case 3:
        fromRadix = 10;  // Decimal
        break;
    case 4:
        fromRadix = 16;  // Hexadecimal
        break;
    default:
        cout << "Enter an appropriate option.";
        exit(-1);
    }

    // Ask the user to input the number they want to convert
    cout << "\nEnter the number : ";
    cin >> num;

    // Validate if the entered number belongs to the selected number system
    if (!checkNumberSystem(num, fromRadix)) {
        cout << "Entered number doesn't belong in the chosen number system." << endl;
        exit(-1);
    }

    // Ask the user to choose the target number system for conversion
    cout << "\nChoose the number system you would like to convert to : " << endl;
    mainMenu();
    cin >> toRadix;

    // Convert the menu choice to the corresponding radix
    switch (toRadix) {
    case 1:
        toRadix = 2;   // Binary
        break;
    case 2:
        toRadix = 8;   // Octal
        break;
    case 3:
        toRadix = 10;  // Decimal
        break;
    case 4:
        toRadix = 16;  // Hexadecimal
        break;
    default:
        cout << "Enter an appropriate option.";
        exit(-1);
    }

    // Handle the case where the source and target number systems are the same
    if (fromRadix == toRadix) {
        cout << "\nEntered number is of the same number system." << endl;
        result = num;  // No conversion needed
    }
    // If converting from a lower radix to a higher radix
    else if (fromRadix < toRadix) {
        result = lowerToHigherRadix(num, fromRadix, toRadix);
    }
    // If converting from a higher radix to a lower radix
    else {
        result = higherToLowerRadix(num, fromRadix, toRadix);
    }

    // Output the result of the conversion
    cout << "\nOutput : " << result << endl;

    return 0;  // Exit the program
}
