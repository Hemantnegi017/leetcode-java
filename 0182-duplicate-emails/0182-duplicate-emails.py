import pandas as pd

def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:
    duplicates = person[person["email"].duplicated(keep=False)]

    return duplicates[["email"]].drop_duplicates(   )