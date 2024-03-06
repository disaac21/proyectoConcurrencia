import pandas as pd

print("start")

column_name = 'body' 
df = pd.read_csv('redditClimateChangeDataset.csv', usecols=[column_name])
print("column work done")

df[column_name] = df[column_name].replace('\n', '\u00A0', regex=True)
print("line feeds replaced")

df[column_name] = df[column_name].apply(lambda x: ''.join([c if ord(c) < 128 else '' for c in x]))
print("ascii corrections")

rows_per_file = 900000

file_chunks = [df[i:i+rows_per_file] for i in range(0, len(df), rows_per_file)]

for i, chunk in enumerate(file_chunks):
    chunk.to_csv(f'outCleared_{i}.csv', index=False)
    print(f'outCleared_{i}.csv done')

print("done")