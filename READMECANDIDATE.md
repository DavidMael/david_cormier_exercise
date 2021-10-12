# Candidate README file

## Completion
Both features were implemented, along with the two bonuses for the interface feature.

## Technical comments
This submission uses features not compatible with Java versions older than 7: String switch statements.

## Design comments
To simulate the need for backwards compatibility if the features to complete were updates to a real system, POST requests made without a vehicle are still accepted.
If such an incomplete request is made, or if the vehicle name is not recognized, the price is calculated the same as it was before.