import pandas as pd

print("start")

column_name = 'body' 
df = pd.read_csv('redditClimateChangeDataset.csv', usecols=[column_name])
print("column work done")

df[column_name] = df[column_name].replace('\n', '\u00A0', regex=True)
print("line feeds replaced")

df[column_name] = df[column_name].apply(lambda x: ''.join([c if ord(c) < 128 else '' for c in x]))
print("ascii corrections")

df.to_csv('outCleared.csv', index=False)
print("done")